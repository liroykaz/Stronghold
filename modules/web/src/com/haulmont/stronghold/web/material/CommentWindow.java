package com.haulmont.stronghold.web.material;

import com.haulmont.cuba.gui.components.AbstractWindow;

import java.util.Map;

/**
 * Created by lebedev on 31.05.2017.
 */
public class CommentWindow extends AbstractWindow {
    @Override
    public void init(Map<String, Object> params) {
        getDialogOptions().setWidth(480).setHeight(320);
    }
}
