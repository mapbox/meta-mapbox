SUMMARY = "A fast JSON parser/generator for C++ with both SAX/DOM style API"
HOMEPAGE = "http://rapidjson.org/"

SECTION = "libs"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://license.txt;md5=cff54e417a17b4b77465198254970cd2"

SRC_URI = "https://github.com/miloyip/rapidjson/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "97cc60d01282a968474c97f60714828c"
SRC_URI[sha256sum] = "c3711ed2b3c76a5565ee9f0128bb4ec6753dbcc23450b713842df8f236d08666"

do_install() {
    install -d ${D}/${includedir}
    cp -r ${S}/include/rapidjson ${D}/${includedir}
}

PACKAGES = "${PN}-dev"
