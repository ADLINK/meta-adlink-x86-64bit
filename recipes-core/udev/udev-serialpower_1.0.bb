#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
SUMMARY = "UART power control features for S0ix autonomous idle"  

DESCRIPTION = "To achieve S0ix autonomous idle \
UART is always on and will never be able to suspend \
even though autosuspend_delay_ms is set.Thus we enable \
runtime power management with sysfs update for UART \
to get power Gated through udev. "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://99-usb-serial-sleep.rules \
"
inherit allarch
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-usb-serial-sleep.rules ${D}${sysconfdir}/udev/rules.d/99-usb-serial-sleep.rules
}


RDEPENDS:${PN} = "udev"

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-usb-serial-sleep.rules"
