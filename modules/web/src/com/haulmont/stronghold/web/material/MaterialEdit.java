package com.haulmont.stronghold.web.material;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.stronghold.entity.Attachment;
import com.haulmont.stronghold.entity.Material;

import javax.inject.Inject;
import java.util.*;

public class MaterialEdit extends AbstractEditor<Material> {
    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;
    @Inject
    private CollectionDatasource<Attachment, UUID> attachmentDs;
    @Inject
    private Datasource<Material> materialDs;
    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private Metadata metadata;
    @Inject
    private Table attachmentTable;
    @Inject
    private DataGrid<Attachment> dataGrid;
    @Inject
    private Button buttonDownload;

    @Override
    public void init(Map<String, Object> params) {
        multiUploadField.addQueueUploadCompleteListener(() -> {
            for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) {
                Attachment attachment = metadata.create(Attachment.class);
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    new RuntimeException("Error saving file to FileStorage", e);
                }
                dataSupplier.commit(fd);
                attachment.setAttachment(fd);
                attachmentDs.addItem(attachment);
                //getItem().getAttachment().add(attachment);
            }
            //materialDs.setItem(getItem());
            //materialDs.commit();
            showNotification("Uploaded files: " + multiUploadField.getUploadsMap().values(), NotificationType.HUMANIZED);
        });

        multiUploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));

        dataGrid.addItemClickListener(event -> {
            buttonDownload.setVisible(true);
        });
    }



    public void onButtonDownloadClick(){
        if(dataGrid.getSingleSelected() != null){
            exportDisplay.show(dataGrid.getSingleSelected().getAttachment(), ExportFormat.OCTET_STREAM);
        }
    }
}