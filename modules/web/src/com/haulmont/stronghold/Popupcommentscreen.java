package com.haulmont.stronghold;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowParams;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.stronghold.entity.Attachment;
import com.haulmont.stronghold.entity.Material;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        newDataGrid.setDatasource(attachmentDs);
    }

    public void onButtonOkClick() {
        close("end");
    }
}


