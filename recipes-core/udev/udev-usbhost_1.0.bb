#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
SUMMARY = "reload xhci driver after receive usb host offline uevent"

DESCRIPTION = ""

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://99-usbhost-bind.rules \
	file://99-usbhost-offline.rules \
"
inherit allarch
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-usbhost-bind.rules ${D}${sysconfdir}/udev/rules.d/99-usbhost-bind.rules
	install -m 0644 ${WORKDIR}/99-usbhost-offline.rules ${D}${sysconfdir}/udev/rules.d/99-usbhost-offline.rules
}


RDEPENDS:${PN} = "udev"

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-usbhost-bind.rules"
FILES:${PN} += "${sysconfdir}/udev/rules.d/99-usbhost-offline.rules"
