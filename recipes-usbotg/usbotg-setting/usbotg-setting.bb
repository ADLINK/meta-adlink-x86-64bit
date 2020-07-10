SUMMARY = "Include otg.sh to /home/root/.usbotgconfig/"
DESCRIPTION = "Start USB OTG Function"
AUTHOR = "Faust.Huang"
SECTION = "examples"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

RDEPENDS_${PN} += "bash"

SRC_URI = "file://otg.sh"

S = "${WORKDIR}"

do_install() {
    install -d 0755 ${D}/home/root/.usbotgconfig/
	install -m 0755 ${S}/otg.sh ${D}/home/root/.usbotgconfig/otg.sh
}

FILES_${PN} += "/home/root/.usbotgconfig/otg.sh"
