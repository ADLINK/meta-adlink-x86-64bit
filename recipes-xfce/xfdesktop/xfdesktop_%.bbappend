SUMMARY = "ADLINK XFCE Desktop Manager "
SECTION = "x11/base"
AUTHOR = "Dinesh kumar"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-Added-Adlink-wallpaper.patch \
		   file://adlink.jpg \
		   file://0002-Adlink-Default-JPG-file.patch \	
"
 
do_configure:append() {
 cp -a ${WORKDIR}/adlink.jpg  ${WORKDIR}/xfdesktop-4.16.0/backgrounds 
}

FILES_${PN} += "${datadir}/backgrounds"
