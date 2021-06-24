package com.company.diskexchange.web.screens.disk;

import com.haulmont.cuba.gui.screen.*;
import com.company.diskexchange.entity.Disk;

@UiController("diskexchange_Disk.browse")
@UiDescriptor("disk-browse.xml")
@LookupComponent("disksTable")
@LoadDataBeforeShow
public class DiskBrowse extends StandardLookup<Disk> {
}