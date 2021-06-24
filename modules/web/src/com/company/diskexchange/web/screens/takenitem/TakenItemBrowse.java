package com.company.diskexchange.web.screens.takenitem;

import com.company.diskexchange.entity.Disk;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.diskexchange.entity.TakenItem;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;

@UiController("diskexchange_TakenItem.browse")
@UiDescriptor("taken-item-browse.xml")
@LookupComponent("takenItemsTable")
@LoadDataBeforeShow
public class TakenItemBrowse extends StandardLookup<TakenItem> {
    @Inject
    private CollectionLoader<TakenItem> takenItemsDl;
    @Inject
    private GroupTable<TakenItem> takenItemsTable;
    @Inject
    private UserSession userSession;
    @Inject
    private Dialogs dialogs;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {
        takenItemsDl.setParameter("user",userSession.getUser());
        takenItemsTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent -> {
                    TakenItem takenItem = takenItemsTable.getSingleSelected();
                    if (takenItem != null) {
                        onReturnDisk (takenItem);
                    }
                }));
        takenItemsTable.setEnterPressAction(new BaseAction("enterPressAction")
                .withHandler(actionPerformedEvent -> {
                    TakenItem takenItem = takenItemsTable.getSingleSelected();
                    if (takenItem != null) {
                        onReturnDisk (takenItem);
                    }
                }));
    }

    private void onReturnDisk (TakenItem takenItem){
        dialogs.createOptionDialog()
                .withCaption("Return disk")
                .withMessage("Do you really want to return this disk?")
                .withActions(
                        new DialogAction(DialogAction.Type.YES)
                                .withHandler(e -> {
                                    dataManager.remove(takenItem);
                                    takenItemsDl.load();
                                }),
                        new DialogAction(DialogAction.Type.NO)
                )
                .show();
    }
}