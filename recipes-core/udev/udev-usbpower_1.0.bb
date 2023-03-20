#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
SUMMARY = "Enable USB Mice as wakeup source"

DESCRIPTION = "USB Mice is wakeup source capable, however \
Linux kernel is not enabling it by default due to legacy reason \
and its settings is left as a policy decision which can be set \
through UDEV rules."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://99-usbmouse-wakeup.rules \
"
inherit allarch
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-usbmouse-wakeup.rules ${D}${sysconfdir}/udev/rules.d/99-usbmouse-wakeup.rules
}


RDEPENDS:${PN} = "udev"

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-usbmouse-wakeup.rules"
