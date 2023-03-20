#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
SUMMARY = "Enable ALPM for SATA controllers"

DESCRIPTION = "SATA Agressive Low Power Mode (ALPM) \
is a feature to allow power saving policies be configured \
by user through sysfs interface of the SCSI Host. \
SCSI by default is setting max_performance for the policy \
thus we create this udev to update to min_power, for maximum \
power saving."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://99-sata-powersave.rules \
"
inherit allarch
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-sata-powersave.rules ${D}${sysconfdir}/udev/rules.d/99-sata-powersave.rules
}


RDEPENDS:${PN} = "udev"

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-sata-powersave.rules"
