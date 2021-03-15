require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-config:${THISDIR}/files:"

LINUX_VERSION_EXTENSION = "-intel-${LINUX_KERNEL_TYPE}"
PV = "${LINUX_VERSION}+git${SRCPV}"

DEPENDS += "util-linux-native openssl-native elfutils-native lz4-native"

# To fix do_configure issue
do_kernel_configme[depends] += "${PN}:do_prepare_recipe_sysroot"

BSPSUBTYPE_x86-64 = "x86"
BSP_SUBTYPE ??= "${BSPSUBTYPE}"

##########
# x86_64
##########

SRC_URI_append_x86-64 = \
" file://bsp/${BSP_SUBTYPE}/defconfig \
  file://bsp/${BSP_SUBTYPE}/intel-dev.scc \
"

# qemu virtio guest
SRC_URI_append_x86-64 = " file://bsp/${BSP_SUBTYPE}/virtio-guest.scc"

# Optional kernel security harderning that may interfere with debugging
SRC_URI_append_x86-64 = " ${@bb.utils.contains('DISTRO_FEATURES', 'hardened', 'file://bsp/${BSP_SUBTYPE}/security.scc', '', d)}"
DEPENDS_append_x86-64 = " ${@bb.utils.contains('DISTRO_FEATURES', 'hardened', 'openssl-native', '', d)}"
INHIBIT_PACKAGE_STRIP = "1"

# are we using backport-iwlwifi?
SRC_URI_append_x86-64 = " ${@bb.utils.contains("DISTRO_FEATURES","backport-iwlwifi", "file://bsp/${BSP_SUBTYPE}/no-wifi.cfg", "file://bsp/${BSP_SUBTYPE}/yes-wifi.cfg", d)}"

# do we want TPM?
SRC_URI_append_x86-64 = " ${@bb.utils.contains("MACHINE_FEATURES","tpm", "file://bsp/${BSP_SUBTYPE}/yes-tpm.cfg", "file://bsp/${BSP_SUBTYPE}/no-tpm.cfg", d)}"

# from meta-virtualization, optional for zeus
include ${@bb.utils.contains('LAYERSERIES_CORENAMES', 'zeus', 'recipes-kernel/linux/linux-yocto_virtualization.inc', '', d)}

#########
# common
#########

SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'dm-verity', 'file://dmverity.cfg', '', d)}"
SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'smack', 'file://lsm-stacking.cfg', '', d)}"
SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'lsm-debug', 'file://lsm-debug.cfg', '', d)}"

SRC_URI_append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=master;destsuffix=${KMETA}"
SRCREV_meta ?= "8b7b8b81908ae2fb83c5e367419f7e7dd1fd4f54"
KMETA ?= "kernel-meta"

#########
# optional stub settings
#########
include recipes-kernel/linux/linux-intel-ese-internal.inc

########
# Networkproxy variant
########
BBCLASSEXTEND_append = " kernel-networkproxy:"

########
# Network boot support
########
SRC_URI_append = "${@bb.utils.contains('MACHINE_FEATURES', 'kernel-isci-boot', ' file://common/isci-boot.cfg', '', d)}"
SRC_URI_append = "${@bb.utils.contains('MACHINE_FEATURES', 'kernel-builtin-ethernet', ' file://common/builtin-ethernet.cfg', '', d)}"
