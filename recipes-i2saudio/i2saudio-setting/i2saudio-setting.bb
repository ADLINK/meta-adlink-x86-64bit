SUMMARY = "Setup i2s audio firmware and execute script"
DESCRIPTION = "Start i2s audio Function"
AUTHOR = "Dinesh kumar"
SECTION = "examples"
LICENSE = "CLOSED"

PR = "r0"

RDEPENDS_${PN} += "bash"

SRC_URI = " file://verifyaic3107.sh"
SRC_URI += "file://LIBASRC.bin"
SRC_URI += "file://dsp_fw_release.bin"
SRC_URI += "file://2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob"
SRC_URI += "file://5a98-INTEL-EDK2-2-tplg.bin"
SRC_URI += "file://setup_aic3107.sh"
SRC_URI += "file://setup_mclk.sh"
SRC_URI += "file://setupticodec.sh"
SRC_URI += "file://2ch_48sine.wav"
SRC_URI += "file://acpi_override"


S = "${WORKDIR}"

do_install() {

    install -d 0755 ${D}/home/root/.i2saudioconfig
    install -d 0755 ${D}${base_libdir}/firmware/

    
	install -m 0755 ${S}/verifyaic3107.sh ${D}/home/root/.i2saudioconfig/verifyaic3107.sh
	install -m 0755 ${S}/2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob ${D}/home/root/.i2saudioconfig/2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob
	install -m 0755 ${S}/setup_aic3107.sh ${D}/home/root/.i2saudioconfig/setup_aic3107.sh
	install -m 0755 ${S}/setup_mclk.sh ${D}/home/root/.i2saudioconfig/setup_mclk.sh
	install -m 0755 ${S}/setupticodec.sh ${D}/home/root/.i2saudioconfig/setupticodec.sh
	install -m 0755 ${S}/2ch_48sine.wav ${D}/home/root/.i2saudioconfig/2ch_48sine.wav
	install -m 0755 ${S}/acpi_override ${D}/home/root/.i2saudioconfig/acpi_override

	install -m 0755 ${S}/dsp_fw_release.bin ${D}${base_libdir}/firmware/dsp_fw_release.bin
	install -m 0755 ${S}/LIBASRC.bin ${D}${base_libdir}/firmware/LIBASRC.bin
	install -m 0755 ${S}/5a98-INTEL-EDK2-2-tplg.bin ${D}${base_libdir}/firmware/5a98-INTEL-EDK2-2-tplg.bin


}

FILES_${PN} += "/home/root/.i2saudioconfig/2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob /lib/firmware/dsp_fw_release.bin /lib/firmware/LIBASRC.bin \
				/lib/firmware/5a98-INTEL-EDK2-2-tplg.bin \
				/home/root/.i2saudioconfig/verifyaic3107.sh \
				/home/root/.i2saudioconfig/setup_aic3107.sh \
				/home/root/.i2saudioconfig/setup_mclk.sh \
				/home/root/.i2saudioconfig/2ch_48sine.wav \
				/home/root/.i2saudioconfig/acpi_override \
				/home/root/.i2saudioconfig/setupticodec.sh "

