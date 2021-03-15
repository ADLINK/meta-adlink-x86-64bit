LICENSE = "CLOSED"


# reboot for xfce4
SRC_URI="file://reboot.desktop \
	 file://suspend.desktop "


S = "${WORKDIR}"

# Tasks
do_install() {
       
        install -d -m 0755 ${D}/usr/share/applications

        cp -a ${WORKDIR}/reboot.desktop ${D}/usr/share/applications

}


do_package_qa() {
}

INSANE_SKIP_${PN} = "already-stripped"
