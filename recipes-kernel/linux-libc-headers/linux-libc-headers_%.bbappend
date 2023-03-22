FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
THISPATCHDIR := "${THISDIR}"
SRC_URI:append = "${@bb.utils.contains('DISTRO_FEATURE', 'libc-abi-breaker-xdp', ' file://0001-net-xdp-add-txtime-field-in-xdp_desc-in-header-file.patch', '', d)}"

python(){
  xdp_message = """
***********************************************************************
*** You have libc-abi-breaker-xdp set in DISTRO_FEATURES (mc:{0})
*** This breaks libc ABI compatibility
*** Please also ensure the running kernel has a consistent if_xdp.h ABI
*** and inspect the patches if needed in:
*** {1}
***********************************************************************
"""

  ft = d.getVar('DISTRO_FEATURES') or ''
  dir = d.getVar('THISPATCHDIR')
  mc = d.getVar('BB_CURRENT_MC')
  if 'libc-abi-breaker-xdp' in ft.split():
    bb.warn(xdp_message.format(mc, dir))
}
