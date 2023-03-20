

DISTRO_FEATURES:append = " systemd x11 virtualisation opengl vulkan"
#DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
#VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

IMAGE_FSTYPES = " wic.bmap wic.gz"
DISK_SIGNATURE_UUID = ""

WKS_ADLINK_ROOT_FS = "ext4"
WKS_FILE:intel-corei7-64 = "adlink-efidisk.wks.in"
WKS_ADLINK_ROOT_SIZE_MB = "6146"
WKS_ADLINK_DATA_SIZE_MB = "1024"
WKS_ADLINK_SWAP_SIZE_MB = "1024"
WKS_ADLINK_BOOT_SIZE_MB = "128"

# Runtime environment export setting for x11
IMAGE_INSTALL:append = " xserver-nodm-config xinit-env"

# Set features for media
IMAGE_INSTALL:append = " gstreamer1.0-libav"
DISTRO_FEATURES:append = " msdk onevpl"
IMAGE_INSTALL:append = " intel-media-driver"
IMAGE_INSTALL:append = "${@bb.utils.contains("DISTRO_FEATURES","msdk", " intel-mediasdk", "", d)}"
IMAGE_INSTALL:append = "${@bb.utils.contains("DISTRO_FEATURES","msdk", " intel-mediasdk-samples", "", d)}"
IMAGE_INSTALL:append = "${@bb.utils.contains("DISTRO_FEATURES","onevpl", " onevpl onevpl-intel-gpu", "", d)}"
PACKAGECONFIG:append:pn-gstreamer1.0-libav = " libav"
PACKAGECONFIG:append:pn-gstreamer1.0-plugins-base = "${@bb.utils.filter('DISTRO_FEATURES', 'opengl', d)}"
IMAGE_INSTALL:append = " vulkan-loader"

# mesa iris driver
PACKAGECONFIG:append:pn-mesa:class-target = " gallium gallium-llvm"
MESA_FORCE_DRIVER = "iris"
PREFERRED_PROVIDER_virtual/mesa-native = "${PREFERRED_PROVIDER_virtual/mesa}-native"
PACKAGECONFIG:append:pn-mesa-native:class-native = " gles"
# clang/llvm native build is broken, mesa doing the insane by using native llvm to find out about host llvm
# make sure some PACKAGECONFIG is at least common in meta-clang clang/llvm
## Dunfell clang10 is bugged, causing llvm/clang constructors to run twice if tools depending on it is built with
## shared clang/llvm runtime libraries
##
## We still want the compiler to be dynamically linked on the runtime image if possible due to image size concerns
## reference: https://reviews.llvm.org/file/data/5mlinpbqf726tpeke5xr/PHID-FILE-xmzquxeysicqtqdiuyxi/file
PACKAGECONFIG:append:pn-clang = " rtti eh  shared-libs"
PACKAGECONFIG:append:pn-clang-native = " rtti eh"

DISTRO_FEATURES:append = " dri3"



# Required additional host tools
HOSTTOOLS += "git-lfs"

# Enable ocl-icd and neo for elkhart-lake
IMAGE_INSTALL:append = " ocl-icd "

# Enable freeglut for elkhart-lake
IMAGE_INSTALL:append = " freeglut"

EXTRA_OECONF:append:pn-tpm2-tss = " --with-tctidefaultmodule=libtss2-tcti-tabrmd.so"

# Add multimedia components
DISTRO_FEATURES:append = " pulseaudio"

# linux-firmware
IMAGE_INSTALL:append = " linux-firmware intel-linux-firmware"

# Enable TPM drivers
MACHINE_FEATURES:append = " tpm"

# X11-related
IMAGE_INSTALL:append = " xinput"

# Install TSN tool
IMAGE_INSTALL:append = " ethtool iproute2 iproute2-tc iperf3 tcpdump linuxptp stress-ng"


# use openssh instead of dropbear
IMAGE_FEATURES:append = " ssh-server-openssh"

# default kernel (virtual provider set in multiconfig with internal overrides)
IMAGE_INSTALL:append = " kernel-image kernel-modules"

#Add usb_modeswitch support
IMAGE_INSTALL:append = " usb-modeswitch"

# autoload modules
KERNEL_MODULE_AUTOLOAD:append = " configfs uhid"

# OS-release info
IMAGE_INSTALL:append = " os-release"

# Remove initscripts from the image altogether.
#VIRTUAL-RUNTIME_initscripts = ""

###################
# OpenVINO PACKAGES
###################

# Enable clDNN only when needed, as this will pull in additional compile-time
# and runtime dependencies for Intel Graphics Compute Runtime for OpenCL
PACKAGECONFIG:append:pn-openvino-inference-engine = " opencl"

# Enable building inference engine python API.
PACKAGECONFIG:append:pn-openvino-inference-engine = " python3"

# This adds inference engine related libraries to the target image
IMAGE_INSTALL:append = " openvino-inference-engine"

# This adds inference engine samples to the target image
IMAGE_INSTALL:append = " openvino-inference-engine-samples"

# Include inference engine python API package to the target image.
# This is required for running e2e_oss test cases
IMAGE_INSTALL:append = " openvino-inference-engine-python3"

# Enable MYRIAD plugin
IMAGE_INSTALL:append = " openvino-inference-engine-vpu-firmware"

# Include model optimizer to the target image.
# This is required for running e2e_oss test cases
IMAGE_INSTALL:append = " openvino-model-optimizer"

# python3 packages needed by the inference engine python test script to transform the input image to expected format
IMAGE_INSTALL:append = " python3-opencv python3-numpy"

# Include optimized deep learning models and a set of demos
IMAGE_INSTALL:append = " open-model-zoo"

########## clang/llvm size problems
BAD_RECOMMENDATIONS:append = " clang-staticdev"

# Adding recipes for platform specific changes
IMAGE_INSTALL:append = " audio-hda-load"

# usb mouse wakeup and SATA PM and GBE and Serial PM
IMAGE_INSTALL:append = " udev-usbpower udev-satapower udev-gbepower udev-serialpower"


# Enable tpm2-abrmd service
SYSTEMD_AUTO_ENABLE:pn-tpm2-abrmd = "enable"


# Additional serial consoles
APPEND:append = " console=ttyS4,115200n8 console=ttyS5,115200n8 i915.force_probe=*" 
APPEND += "video=eDP-1:d rootwait console=ttyS0,115200 console=tty0 i915.enable_guc=2"
APPEND:append = " udmabuf.list_limit=8192"



