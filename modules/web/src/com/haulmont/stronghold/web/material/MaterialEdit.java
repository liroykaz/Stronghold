package com.haulmont.stronghold.web.material;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.stronghold.entity.Material;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class MaterialEdit extends AbstractEditor<Material> {

    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;
    @Inject
    private Datasource<Material> materialDs;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Button clearImageBtn;
    @Inject
    private ExportDisplay exportDisplay;

    @Override
    public void init(Map<String, Object> params) {
        multiUploadField.addQueueUploadCompleteListener(() -> {
            for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                // save file to FileStorage
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    new RuntimeException("Error saving file to FileStorage", e);
                }
                // save file descriptor to database
                getItem().setAttachment(dataSupplier.commit(fd));
            }
            showNotification("Uploaded files: " + multiUploadField.getUploadsMap().values(), NotificationType.HUMANIZED);
            //multiUploadField.clearUploads();

        });

        multiUploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));
    }

    public void onDownloadImageBtnClick() {
        if (getItem().getAttachment() != null)
            exportDisplay.show(getItem().getAttachment(), ExportFormat.OCTET_STREAM);
        
    }

    public void onClearImageBtnClick() {
        getItem().setAttachment(null);
    }



    
}