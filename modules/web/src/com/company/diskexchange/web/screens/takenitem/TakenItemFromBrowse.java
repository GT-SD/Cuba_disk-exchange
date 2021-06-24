package com.company.diskexchange.web.screens.takenitem;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.diskexchange.entity.TakenItem;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;

@UiController("diskexchange_TakenItemFrom.browse")
@UiDescriptor("taken-item-from-browse.xml")
@LookupComponent("takenItemsTable")
@LoadDataBeforeShow
public class TakenItemFromBrowse extends StandardLookup<TakenItem> {
    @Inject
    private CollectionLoader<TakenItem> takenItemsDl;
    @Inject
    private UserSession userSession;

    @Subscribe
    public void onInit(InitEvent event) {
        takenItemsDl.setParameter("owner", userSession.getUser());
    }
}