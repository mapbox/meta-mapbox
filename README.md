# meta-mapbox

This layer contains recipes for building the [Mapbox Qt SDK](https://github.com/mapbox/mapbox-gl-native/tree/master/platform/qt)
for [Yocto](https://www.yoctoproject.org/).

## Dependencies

 ```
 https://github.com/meta-qt5/meta-qt5
 ```

## Usage

This layer was tested on Yocto Fido (GCC4.9), Jethro and Krogoth (recommended)
with the following target machines and their respective `local.conf`:

 * `genericx86-64` (X11 + OpenGL)

 ```
 IMAGE_INSTALL_append = " qmapboxgl"
 ```

 * `raspberrypi3` (EGLFS + OpenGL ES 2)

 ```
 GPU_MEM = "256"

 IMAGE_INSTALL_append = " qmapboxgl"

 PACKAGECONFIG_append_pn-qtbase = " gles2 accessibility"
 PACKAGECONFIG_append_pn-qmapboxgl = " gles2"
 ```

The `qmapboxgl` target will install 2 sample applications: `qmapboxgl` (C++)
and `qquickmapboxgl` (QML). It will also provide development headers when set
as dependency of your own recipe. For `raspberrypi3`, remember to append
`-platform eglfs` when running the example application.

## Contributing

To contribute to this layer you can [submit pull requests](https://github.com/mapbox/meta-mapbox/pull/new/master).
