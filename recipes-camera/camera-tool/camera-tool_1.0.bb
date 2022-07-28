SUMMARY = "Compiles and installs executable to provide a simple tool to access usb camera LED"
LICENSE = "CLOSED"

SRC_URI = "\
    file://SP_V4L2_API-2021-07-19.tar.gz \
"

S = "${WORKDIR}/SP_V4L2_API-2021-07-19/Demo_V4L2"

MAKEARCH ?= ""
MAKEARCH_intel-corei7-64 = "x64"
MAKEARCH_aarch64 = "aarch64"

do_compile() {
	${MAKE} ARCH=${MAKEARCH} OUTPUT=${PN} -C ${S} all
}

do_install() {
    install -d -m 0755 ${D}/usr${base_bindir}
    install -m 0755 ${S}/${PN} ${D}/usr${base_bindir}/${PN}
}

FILES_${PN} += " /usr${base_bindir}/${PN}"
