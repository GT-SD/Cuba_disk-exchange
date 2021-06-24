package com.company.diskexchange.web.screens.disk;


import com.haulmont.cuba.gui.screen.*;
import com.company.diskexchange.entity.Disk;


@UiController("diskexchange_Disk.edit")
@UiDescriptor("disk-edit.xml")
@EditedEntityContainer("diskDc")
@LoadDataBeforeShow
public class DiskEdit extends StandardEditor<Disk> {


}