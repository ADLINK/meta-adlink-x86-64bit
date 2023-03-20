#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
SUMMARY = "GBE power control features for S0ix autonomous idle"  

DESCRIPTION = "To achieve S0ix autonomous idle \
GBE is always on and will never enter RTD3.Thus \
we disable snmpd daemon which keeps GBE busy and \
enable runtime power management with sysfs update for GBE \
to get power Gated through udev. "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://99-pci-gbe-sleep.rules \
"
inherit allarch
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-pci-gbe-sleep.rules ${D}${sysconfdir}/udev/rules.d/99-pci-gbe-sleep.rules
}


RDEPENDS:${PN} = "udev"

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-pci-gbe-sleep.rules"
