package com.haulmont.stronghold;

import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.stronghold.entity.Attachment;

import javax.inject.Inject;

public class ScreenAddSingleAttach extends AbstractEditor {

    @Inject
    private Datasource<Attachment> attachmentDs;

    public void onButtonClick() {
        close("end");
    }
}