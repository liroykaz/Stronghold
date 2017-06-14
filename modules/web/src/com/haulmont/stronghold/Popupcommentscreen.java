package com.haulmont.stronghold;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.WindowParams;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.stronghold.entity.Attachment;
import com.haulmont.stronghold.entity.Material;
import org.apache.commons.io.FilenameUtils;

import javax.inject.Inject;
import java.util.*;

public class Popupcommentscreen extends AbstractWindow {
    @Inject
    private DataGrid newDataGrid;
    @Inject
    private CollectionDatasource<Attachment, UUID> attachmentDs;
    @Inject
    private CollectionDatasource<Attachment, UUID> attachmentTemporaryDs;
    @Inject
    private Datasource materialDs;
    @Inject
    private Attachment attachment;
    @Inject
    private Button buttonOk;
    @Inject
    private Metadata metadata;
    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;

    private Boolean allCommentsNotNull = false;

    @Override
    public void init(Map<String, Object> params) {
        ArrayList<UUID> arrayList;
        super.init(params);
        attachmentDs = (CollectionDatasource<Attachment, UUID>) params.get("map");
//        arrayList = (ArrayList<UUID>) attachmentDs.getItemIds();
//        for(int i=0;i<arrayList.size();i++){
//            attachment = attachmentDs.getItem(arrayList.get(i));
//            if(attachment.getComments().equals("")){
//                attachmentDs.removeItem(attachment);
//            }
//        }
//        newDataGrid.setDatasource(attachmentDs);
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
                newDataGrid.setDatasource(attachmentDs);
            }
            //mapFiles.put("map", attachmentDs);
            //openWindow("popupCommentScreen.copy", WindowManager.OpenType.DIALOG, mapFiles);
        });
    }

    public void onButtonOkClick() {
        ArrayList<Attachment> attachmentArrayList = new ArrayList<Attachment>(attachmentDs.getItems());
        for(int i = 0; i < attachmentDs.size(); i++) {
            //attachmentArrayList = (ArrayList<Attachment>) attachmentDs.getItems();
            if(attachmentArrayList.get(i).getComments() == null){
                showNotification("Проверьте заполнение всех обязательных полей!");
                allCommentsNotNull = false;
                break;
            } else{
                allCommentsNotNull = true;
            }
        }
        if(allCommentsNotNull){
            close("end");
        }
    }
}


