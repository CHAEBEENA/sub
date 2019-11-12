package kr.co.gadaga.official.ui.announcement

import kr.co.gadaga.official.data.model.Announcement

interface AnnouncementActionHandler {

    fun dismissAnnouncementInfoCard()

    fun openAnnouncementOnMap()

    fun launchAnnouncementWebsite()

    fun startAccouncement(announcement : Announcement)
}