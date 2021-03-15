SUMMARY = "Setup camera RPM and execute script"
DESCRIPTION = "Start camera Function"
AUTHOR = "Dinesh kumar"
SECTION = "examples"
LICENSE = "CLOSED"

PR = "r0"

RDEPENDS_${PN} += "bash"

SRC_URI += "file://aiqb-1.0.0-2720.a4ef266.x86_64"
SRC_URI += "file://camera.sh"
SRC_URI += "file://icamerasrc-1.0.0-2720.4847058.x86_64"
SRC_URI += "file://ipu4fw-1.0.0-2720.88ddf58.DSS.signed.x86_64"
SRC_URI += "file://libcamhal-1.0.0-2720.d122692c.x86_64"
SRC_URI += "file://libiaaiq-1.0.0-2720.df05787.x86_64"
SRC_URI += "file://libiacss-1.0.0-2720.ae8628e.x86_64"
SRC_URI += "file://iotg_camera-1.0.0-2558.x86_64"


S = "${WORKDIR}"

do_install() {

	install -d 0755 ${D}/home/root/.cameraconfig


	install -m 0755 ${S}/camera.sh ${D}/home/root/.cameraconfig/camera.sh
	install -m 0755 ${S}/icamerasrc-1.0.0-2720.4847058.x86_64 ${D}/home/root/.cameraconfig/icamerasrc-1.0.0-2720.4847058.x86_64
	install -m 0755 ${S}/ipu4fw-1.0.0-2720.88ddf58.DSS.signed.x86_64 ${D}/home/root/.cameraconfig/ipu4fw-1.0.0-2720.88ddf58.DSS.signed.x86_64
	install -m 0755 ${S}/libcamhal-1.0.0-2720.d122692c.x86_64 ${D}/home/root/.cameraconfig/libcamhal-1.0.0-2720.d122692c.x86_64
	install -m 0755 ${S}/libiaaiq-1.0.0-2720.df05787.x86_64 ${D}/home/root/.cameraconfig/libiaaiq-1.0.0-2720.df05787.x86_64
	install -m 0755 ${S}/libiacss-1.0.0-2720.ae8628e.x86_64 ${D}/home/root/.cameraconfig/libiacss-1.0.0-2720.ae8628e.x86_64
	install -m 0755 ${S}/iotg_camera-1.0.0-2558.x86_64 ${D}/home/root/.cameraconfig/iotg_camera-1.0.0-2558.x86_64
install -m 0755 ${S}/aiqb-1.0.0-2720.a4ef266.x86_64 ${D}/home/root/.cameraconfig/aiqb-1.0.0-2720.a4ef266.x86_64
}

FILES_${PN} += "/home/root/.cameraconfig/aiqb-1.0.0-2720.a4ef266.x86_64 /home/root/.cameraconfig/camera.sh /home/root/.cameraconfig/icamerasrc-1.0.0-2720.4847058.x86_64 /home/root/.cameraconfig/ipu4fw-1.0.0-2720.88ddf58.DSS.signed.x86_64 /home/root/.cameraconfig/libcamhal-1.0.0-2720.d122692c.x86_64 /home/root/.cameraconfig/libiaaiq-1.0.0-2720.df05787.x86_64 /home/root/.cameraconfig/libiacss-1.0.0-2720.ae8628e.x86_64 /home/root/.cameraconfig/iotg_camera-1.0.0-2558.x86_64"
