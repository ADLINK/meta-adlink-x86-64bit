DESCRIPTION = "Adlink Core Image Minimal with SEMA/TPM2.0 Support"
SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_INSTALL_append = " startupconfig"

#TOOLS
IMAGE_INSTALL_append = " git curl wget which busybox bzip2 cmake bash tar gzip kmod ethtool ifupdown inetutils init-ifupdown iw minicom net-tools vim openssh lshw ntp ntpdate libstdc++ i2c-tools"

#TPM2
IMAGE_INSTALL_append = " packagegroup-security-tpm2"

## SEMA applications
IMAGE_INSTALL_append = " sema"


export IMAGE_BASENAME = "adlink-mini-x86-cEL"
