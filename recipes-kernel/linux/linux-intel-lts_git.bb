KERNEL_SRC_URI ?= "git://github.com/intel/linux-intel-lts.git;protocol=https;branch=5.4/yocto;name=machine"
SRC_URI = "${KERNEL_SRC_URI}"
SRCREV_machine ?= "698dc049f6493327076986587f9d0016d6f97a20"
LINUX_VERSION ?= "5.4"
LINUX_KERNEL_TYPE = "lts"
KERNEL_PACKAGE_NAME = "${PN}-kernel"

require recipes-kernel/linux/linux-intel-ese.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

# Optional kernel security harderning that may interfere with debugging
SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'hardened', 'file://bsp/${BSP_SUBTYPE}/security.scc', '', d)}"
DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'hardened', 'openssl-native', '', d)}"
INHIBIT_PACKAGE_STRIP = "${@bb.utils.contains('DISTRO_FEATURES', 'hardened', '1', '0', d)}"

# Programmable Software Engine
SRC_URI_append = " file://ishtp-5.4.scc"

# IO patches
SRC_URI_append = " file://io-5.4.scc"

# xdp or libbpf patches
SRC_URI_append = " file://libbpf-5.4.scc"

# Graphics patch
SRC_URI_append = " file://gfx-5.4.scc"

# Ethernet patches
SRC_URI_append = " file://ethernet-5.4.scc"

# Network Proxy
SRC_URI_append = " file://bsp/networkproxy.scc"

# TPM
SRC_URI_append = " file://tpm2.cfg"

# Watchdog timeout sysfs entry
SRC_URI_append = " file://wdt.cfg"

# Hdmi Hot Plug
SRC_URI_append = " file://hdmi_hotplug.cfg"

# Additional Kernel Features to support Intel C38XX Soc
KERNEL_FEATURES_append = " features/x2apic/x2apic.scc"
KERNEL_FEATURES_append = " features/vfio/vfio.scc"
KERNEL_FEATURES_append = " features/numa/numa.scc"
KERNEL_FEATURES_append = " features/mtd/mtd.scc"
KERNEL_FEATURES_append = " features/iommu/iommu.scc"
KERNEL_FEATURES_append = " features/intel-txt/intel-txt.scc"

# IXGBE & IXGBEVF Ethernet drivers
IMAGE_INSTALL_append = " ixgbe"
IMAGE_INSTALL_append = " ixgbevf"
