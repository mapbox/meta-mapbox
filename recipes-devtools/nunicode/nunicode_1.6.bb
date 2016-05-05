SUMMARY = "Fast, small and portable Unicode library and SQLite3 extension"
DESCRIPTION = "This is i18n library implementing Unicode 8.0."
HOMEPAGE = "https://bitbucket.org/alekseyt/nunicode"

LICENSE ="MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a11f15b5d9216bea2116fcebac559a91"

SECTION = "libs"

DEPENDS = "sqlite3"

S = "${WORKDIR}/alekseyt-nunicode-34f278da1e6a"

SRC_URI = "https://bitbucket.org/alekseyt/nunicode/get/1.6.tar.bz2"

SRC_URI[md5sum] = "5e8670f4c90b02fcfd94baaa7a80e715"
SRC_URI[sha256sum] = "9ef3c9bfd127dc98a2f46c731fee9fd37be4d49c9bb28449452e1d00c0a3c237"

CMAKE_EXTRACONF = "-DCMAKE_BUILD_TYPE=Release"
OECMAKE_CXX_FLAGS = "-fPIC"

inherit cmake

do_configure () {
    cmake_do_configure
}

do_install () {
    cmake_do_install
}

FILES_${PN}-dev += "\
    ${libdir}/cmake/nunicode/nunicode-config.cmake \
    ${libdir}/cmake/nunicode/nunicode-config-noconfig.cmake"

PACKAGES = "${PN}-dev ${PN}-staticdev"
