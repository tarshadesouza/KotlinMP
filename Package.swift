// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "MyApp",
    platforms: [
        .iOS(.v13),
.macOS(.v11)
    ],
    products: [
        .library(
            name: "MyApp",
            targets: ["MyApp"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "MyApp",
            path: "./MyApp.xcframework"
        ),
    ]
)
