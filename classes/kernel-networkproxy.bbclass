# make a networkproxy enabled kernel variant called <kernel recipe name>-networkproxy
FILESEXTRAPATHS:prepend := "${LAYERDIR-ese-bsp}/recipes-kernel/linux/linux-config:"
python networkproxy_virtclass_handler() {
    d.appendVar('PN', '-networkproxy')
    d.appendVar('LINUX_KERNEL_TYPE', '-networkproxy')
    d.appendVar('SRC_URI', ' file://bsp/networkproxy.scc')
}

addhandler networkproxy_virtclass_handler
networkproxy_virtclass_handler[eventmask] = "bb.event.RecipePreFinalise"
