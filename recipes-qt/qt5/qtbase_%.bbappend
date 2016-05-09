FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_raspberrypi3 = " file://9999-vchostif.patch"

# 99% based on the work from John Madieu <j.madieu at expemb.com>
# https://lists.yoctoproject.org/pipermail/yocto/2016-February/028279.html

do_configure_prepend_raspberrypi3() {
    if ! grep -q 'EGLFS_DEVICE_INTEGRATION' ${S}/mkspecs/linux-oe-g++/qmake.conf; then

        sed -i 's!load(qt_config)!!' ${S}/mkspecs/linux-oe-g++/qmake.conf

        cat >> ${S}/mkspecs/linux-oe-g++/qmake.conf << '        EOF'

            QMAKE_INCDIR_EGL = $$[QT_SYSROOT]${includedir}/interface/vcos/pthreads $$[QT_SYSROOT]${includedir}/interface/vmcs_host/linux
            QMAKE_INCDIR_OPENGL_ES2 = $${QMAKE_INCDIR_EGL}
            QMAKE_LIBS_EGL = -lEGL -lGLESv2

            EGLFS_DEVICE_INTEGRATION = eglfs_brcm

            load(qt_config)

        EOF
    fi
}
