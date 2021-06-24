package com.company.diskexchange.web.screens.disk;

import com.company.diskexchange.entity.TakenItem;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.components.GroupTable;

import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.diskexchange.entity.Disk;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;

@UiController("diskexchange_FreeDisk.browse")
@UiDescriptor("free_disk-browse.xml")
@LookupComponent("disksTable")
@LoadDataBeforeShow
public class FreeDiskBrowse extends StandardLookup<Disk> {
    @Inject
    private CollectionLoader<Disk> disksDl;
    @Inject
    private GroupTable<Disk> disksTable;
    @Inject
    private DataManager dataManager;
    @Inject
    private UserSession userSession;
    @Inject
    private Dialogs dialogs;



    @Subscribe
    public void onInit(InitEvent event) {
        disksDl.setParameter("owner_ID",userSession.getUser().getId());
        disksTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent -> {
                    Disk disk = disksTable.getSingleSelected();
                    if (disk != null) {
                        onTakeDisk (disk);
                    }
                }));
        disksTable.setEnterPressAction(new BaseAction("enterPressAction")
                .withHandler(actionPerformedEvent -> {
                    Disk disk = disksTable.getSingleSelected();
                    if (disk != null) {
                        onTakeDisk (disk);
                    }
                }));
    }

    private void onTakeDisk (Disk disk){
        dialogs.createOptionDialog()
                .withCaption("Take disk")
                .withMessage("Do you really want to take this disk?")
                .withActions(
                        new DialogAction(DialogAction.Type.YES)
                                .withHandler(e -> {
                                    TakenItem takenItem = new TakenItem();
                                    takenItem.setDisk(disk);
                                    takenItem.setUser(userSession.getUser());
                                    dataManager.commit(takenItem);
                                    disksDl.load();
                                }),
                        new DialogAction(DialogAction.Type.NO)
                )
                .show();
    }



}