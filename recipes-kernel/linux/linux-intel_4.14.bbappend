FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


 
SRC_URI_append = " file://leafhill.scc \
		   file://otg.cfg \
	           file://S4_support.cfg \
		   file://0001-Removed-trace_printk-to-avoid-warning-while-booting.patch \
		   file://0001-Allocate-FB-for-HDMI-DP-VGA-at-boot-time-even-device.patch \	
      		   ${@bb.utils.contains('DISTRO_FEATURES', 'tpm', 'file://tpm.scc', '', d)} \
   	           ${@bb.utils.contains('DISTRO_FEATURES', 'tpm2', 'file://tpm2.scc', '', d)} \	
		   ${@bb.utils.contains('AUDIO_FEATURES', 'ssp', 'file://snd_ssp_intel.scc', '', d)} \	 
		   ${@bb.utils.contains('DOCKER_FEATURES', 'enable', 'file://xt-checksum.scc', '', d)} \
   	           ${@bb.utils.contains('DOCKER_FEATURES', 'enable', 'file://ebtables.scc', '', d)} \	
		   ${@bb.utils.contains('DOCKER_FEATURES', 'enable', 'file://vswitch.scc', '', d)} \
		   ${@bb.utils.contains('DOCKER_FEATURES', 'enable', 'file://lxc.scc', '', d)} \
		   ${@bb.utils.contains('DOCKER_FEATURES', 'enable', 'file://docker.scc', '', d)} \
"


# Enable i2c-dev autoload
INTEL_COMMON_AUTOLOAD += "i2c-dev"

do_shared_workdir_append() {
       oe_runmake CC="${KERNEL_CC}" LD="${KERNEL_LD}" AR="${KERNEL_AR}" \
               -C ${STAGING_KERNEL_DIR} O=${STAGING_KERNEL_BUILDDIR} scripts prepare
}
