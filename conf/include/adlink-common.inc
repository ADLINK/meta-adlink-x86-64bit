

DISTRO_FEATURES += " systemd x11 virtualisation opengl es2 wayland"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

IMAGE_FSTYPES = " wic.bmap wic.gz"
DISK_SIGNATURE_UUID = ""

WKS_ADLINK_ROOT_FS = "ext4"
WKS_FILE:intel-corei7-64 = "adlink-efidisk.wks.in"
WKS_ADLINK_ROOT_SIZE_MB = "6146"
WKS_ADLINK_DATA_SIZE_MB = "1024"
WKS_ADLINK_SWAP_SIZE_MB = "1024"
WKS_ADLINK_BOOT_SIZE_MB = "128"



# Set features for media
IMAGE_INSTALL_append = " gstreamer1.0-libav "
DISTRO_FEATURES_append = " msdk vulkan onevpl"
IMAGE_INSTALL_append = " intel-media-driver"
IMAGE_INSTALL_append = "${@bb.utils.contains("DISTRO_FEATURES","msdk", " intel-mediasdk", "", d)}"
IMAGE_INSTALL_append = "${@bb.utils.contains("DISTRO_FEATURES","msdk", " intel-mediasdk-samples", "", d)}"
IMAGE_INSTALL_append = "${@bb.utils.contains("DISTRO_FEATURES","onevpl", " onevpl onevpl-intel-gpu", "", d)}"
PACKAGECONFIG_append_pn-gstreamer1.0-libav = " libav"
PACKAGECONFIG_append_pn-gstreamer1.0-plugins-base = "${@bb.utils.filter('DISTRO_FEATURES', 'opengl', d)}"
IMAGE_INSTALL_append = " vulkan-loader"

HOSTTOOLS += "git-lfs"

# Enable ocl-icd and neo for elkhart-lake
IMAGE_INSTALL_append = " ocl-icd intel-compute-runtime"

# Enable freeglut for elkhart-lake
IMAGE_INSTALL_append = " freeglut"

## X-Server
IMAGE_INSTALL_append = " xserver-xorg xterm xinit-env startupconfig"

# Add multimedia components
DISTRO_FEATURES_append = " pulseaudio"

# linux-firmware
IMAGE_INSTALL_append = " linux-firmware"


# Bluetooth management
IMAGE_INSTALL_append = " bluez5-noinst-tools bluez5-testtools"

# Enable TPM drivers
MACHINE_FEATURES_append = " tpm"

# Install TSN tool
IMAGE_INSTALL_append = " ethtool iproute2 iproute2-tc iperf3 tcpdump linuxptp stress-ng"

#wifi module is handled specially so that it may be possible to have some kernels using the out of tree module and others
# using the internal module, see meta-intel-ese-bsp/classes/kernel-wifi-conf.bbclass
# enabling the driver from backport-iwlwifi disables the kernel in-tree version
DISTRO_FEATURES_append = " backport-iwlwifi-5.4 backport-iwlwifi-5.10"
KERNEL_PROVIDERS_EXTRA_MODULES_WIFI_COMPAT ?= ""
KERNEL_PROVIDERS_EXTRA_MODULES_WIFI_COMPAT_append = "${@bb.utils.contains("DISTRO_FEATURES", "backport-iwlwifi-5.4",  " 5.4",  "", d)}"
KERNEL_PROVIDERS_EXTRA_MODULES_WIFI_COMPAT_append = "${@bb.utils.contains("DISTRO_FEATURES", "backport-iwlwifi-5.10", " 5.10", "", d)}"
KERNEL_PROVIDERS_EXTRA_MODULES[5.4]  += "${@bb.utils.contains("DISTRO_FEATURES", "backport-iwlwifi-5.4",  "backport-iwlwifi", "", d)}"
KERNEL_PROVIDERS_EXTRA_MODULES[5.10] += "${@bb.utils.contains("DISTRO_FEATURES", "backport-iwlwifi-5.10", "backport-iwlwifi", "", d)}"

# autoload modules
KERNEL_MODULE_AUTOLOAD_append = " configfs uhid"

# Additional serial consoles
APPEND_append = " console=ttyS4,115200n8 console=ttyS5,115200n8 i915.force_probe=*" 
APPEND += "video=eDP-1:d rootwait console=ttyS0,115200 console=tty0 i915.enable_guc=2"
APPEND_append = " udmabuf.list_limit=8192"


###################
# OpenVINO PACKAGES
###################

# Enable clDNN only when needed, as this will pull in additional compile-time
# and runtime dependencies for Intel Graphics Compute Runtime for OpenCL
PACKAGECONFIG_append_pn-openvino-inference-engine = " opencl"

# Enable building inference engine python API.
PACKAGECONFIG_append:pn-openvino-inference-engine = " python3"

# This adds inference engine related libraries to the target image
IMAGE_INSTALL_append = " openvino-inference-engine"

# This adds inference engine samples to the target image
IMAGE_INSTALL_append = " openvino-inference-engine-samples"

# Include inference engine python API package to the target image.
# This is required for running e2e_oss test cases
IMAGE_INSTALL_append = " openvino-inference-engine-python3"

# Enable MYRIAD plugin
IMAGE_INSTALL_append = " openvino-inference-engine-vpu-firmware"

# Include model optimizer to the target image.
# This is required for running e2e_oss test cases
IMAGE_INSTALL_append = " openvino-model-optimizer"

# python3 packages needed by the inference engine python test script to transform the input image to expected format
IMAGE_INSTALL_append = " python3-opencv python3-numpy"

# Set preferred version for TBB
PREFERRED_VERSION_tbb = "2021.2%"

# Include optimized deep learning models and a set of demos
IMAGE_INSTALL_append = " open-model-zoo"

##########################

# Adding recipes for platform specific changes
IMAGE_INSTALL_append = " audio-hda-load"

# usb mouse wakeup and SATA PM and GBE and Serial PM
IMAGE_INSTALL_append = " udev-usbpower udev-satapower udev-gbepower udev-serialpower"

# tccsdk dependencies
IMAGE_INSTALL_append = "${@bb.utils.contains("IMAGE_FEATURES", "dev-pkgs", " itt-staticdev", "", d)}"

# Enable tpm2-abrmd service
SYSTEMD_AUTO_ENABLE_pn-tpm2-abrmd = "enable"

## For additional tools/packages
#IMAGE_INSTALL_append = " mcelog evince haveged lshw ntp ntpdate libstdc++ kernel-modules dmidecode "








