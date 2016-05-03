SUMMARY = "An alternative to boost::variant for C++11"
HOMEPAGE = "https://github.com/mapbox/variant"

SECTION = "libs"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79558839a9db3e807e4ae6f8cd100c1c"

SRC_URI = "https://github.com/mapbox/variant/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "d07da38dbba3ce730e26c6b9001e5b54"
SRC_URI[sha256sum] = "cef66e15466b4eea000647714142eea38719f015ce41c9d05d109d1907127360"

do_compile() {
    true
}

do_install() {
    install -d ${D}/${includedir}/mapbox
    cp ${S}/*.hpp ${D}/${includedir}/mapbox
}

PACKAGES = "${PN}-dev"
