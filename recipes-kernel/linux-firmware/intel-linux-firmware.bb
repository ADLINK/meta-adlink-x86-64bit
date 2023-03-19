SUMMARY = "Firmware files for use with sriov support with Linux kernel"
DESCRIPTION = "Intel-linux-firmware providing the i915 firmware file for SRIOV support"
SECTION = "kernel"

LICENSE = "Firmware-i915"

LIC_FILES_CHKSUM = "file://LICENSE.i915;md5=2b0b2e0d20984affd4490ba2cba02570"

NO_GENERIC_LICENSE[Firmware-i915] = "LICENSE.i915"

SRC_URI = "git://github.com/intel/intel-linux-firmware.git;branch=main;protocol=https"

SRCREV = "a9d99513513df9e34e6404e1558ad69669d69259"

S = "${WORKDIR}/git"

do_install () {
        install -d ${D}${nonarch_base_libdir}/firmware/i915/
        cp -r ${S}/*.bin "${D}${nonarch_base_libdir}/firmware/i915/"
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/i915 \
                ${nonarch_base_libdir}/firmware/LICENSE.i915"
