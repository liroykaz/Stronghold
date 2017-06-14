package com.haulmont.stronghold.web.material;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.app.core.file.FileUploadDialog;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.stronghold.entity.Attachment;
import com.haulmont.stronghold.entity.Material;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalSplitPanel;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FilenameUtils;

import javax.inject.Inject;
import java.io.File;
import java.util.*;

public class MaterialEdit extends AbstractEditor {
    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;
    @Inject
    private CollectionDatasource<Attachment, UUID> attachmentDs;
    @Inject
    private CollectionDatasource<Attachment, UUID> addAttachmentDs;
    @Inject
    private Datasource<Material> materialDs;
    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private Metadata metadata;
    @Inject
    private DataGrid<Attachment> dataGrid;
    @Inject
    private Button buttonDownload;
    @Inject
    private PopupButton popupButton;


    @Override
    public void init(Map<String, Object> params) {
        uploadField.addFileUploadSucceedListener(event -> {
            Attachment attachment = metadata.create(Attachment.class);
            FileDescriptor fd = metadata.create(FileDescriptor.class);
            fd.setName(uploadField.getFileName());
            fd.setExtension(FilenameUtils.getExtension(uploadField.getFileName()));

            FileUploadingAPI fileUploading = AppBeans.get(FileUploadingAPI.NAME);
            File file = fileUploading.getFile(uploadField.getFileId());
            fd.setSize(file.length());

            fd.setCreateDate(AppBeans.get(TimeSource.class).currentTimestamp());
            try {
                fileUploading.putFileIntoStorage(uploadField.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Unable to put file to storage", e);
            }
            dataSupplier.commit(fd);
            attachment.setAttachment(fd);
            attachmentDs.addItem(attachment);
            openEditor("stronghold$Attachment.edit", attachment, WindowManager.OpenType.DIALOG);
        });

        uploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));

        Map<String, Object> mapFiles = new HashedMap();
        multiUploadField.addQueueUploadCompleteListener(() -> {
                for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) {
                    Attachment attachment = metadata.create(Attachment.class);
                    UUID fileId = entry.getKey();
                    String fileName = entry.getValue();
                    FileDescriptor fd = metadata.create(FileDescriptor.class);
                    fd.setName(fileName);
                    fd.setExtension(FilenameUtils.getExtension(fileName));
                    fd.setCreateDate(new Date());
                    try {
                        fileUploadingAPI.putFileIntoStorage(fileId, fd);
                    } catch (FileStorageException e) {
                        new RuntimeException("Error saving file to FileStorage", e);
                    }
                    dataSupplier.commit(fd);
                    attachment.setAttachment(fd);
                    attachmentDs.addItem(attachment);
                }
                mapFiles.put("map", attachmentDs);
                openWindow("popupCommentScreen.copy", WindowManager.OpenType.DIALOG, mapFiles);
        });

        multiUploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));

        dataGrid.addItemClickListener(event -> {
            buttonDownload.setEnabled(true);
        });
    }
    
    public void onButtonDownloadClick(){
        if(dataGrid.getSingleSelected() != null){
            exportDisplay.show(dataGrid.getSingleSelected().getAttachment(), ExportFormat.OCTET_STREAM);
        }
    }

    public void onSingleUpload(Component source) {
        Attachment attachment = metadata.create(Attachment.class);
        attachmentDs.addItem(attachment);
       // Map<String, Object> mapFiles = new HashedMap();
        //mapFiles.put("map", attachment);
        openEditor("screenAddSingleAttach", attachment, WindowManager.OpenType.DIALOG);
    }
    
    

    public void onMultiUpload(Component source) {
        Map<String, Object> mapFiles = new HashedMap();
        //Map<String, Object> mapFiles = metadata.create(HashMap.class);
        mapFiles.put("map", attachmentDs);
        openWindow("popupCommentScreen.copy", WindowManager.OpenType.DIALOG, mapFiles);
    }

//    @Override
//    protected boolean preCommit() {
////        try{
////            if(materialDs.getItem().getAttachment() != null) {
////                for (int i = 0; i < materialDs.getItem().getAttachment().size(); i++) {
////                    if (materialDs.getItem().getAttachment().get(i).getComments().equals("")) {
////                        return false;
////                    }
////                }
////            }
////        } catch (Exception ex){
////            showNotification("Пожалуйста, проверьте правильность заполнения полей!");
////        }finally {
////            return super.preCommit();
////        }
//    }
}