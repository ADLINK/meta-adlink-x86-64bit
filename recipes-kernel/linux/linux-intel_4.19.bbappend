FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " file://otg.cfg \
		   file://S4_support.cfg \
		   file://0001-Allocate-FB-for-HDMI-DP-VGA-at-boot-time-even-device.patch \
		   file://0001-Removed-trace_printk-to-avoid-warning-while-booting.patch \
		   file://0001-SMbus.patch \	
"


# Enable i2c-dev autoload
INTEL_COMMON_AUTOLOAD += "i2c-dev"
