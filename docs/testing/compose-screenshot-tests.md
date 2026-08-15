# Compose Preview Screenshot Test

`:screenshot-tests` is an Android-only host module for visual regression checks of the public
Compose-Pickers UI. The official `com.android.compose.screenshot` plugin does not support
Kotlin Multiplatform modules, so it must not be applied to `:pickers` or `:sample`.

The test cases live in
[`screenshot-tests/src/screenshotTest/kotlin`](../../screenshot-tests/src/screenshotTest/kotlin).
They use fixed values rather than the clock so reference images are deterministic.

## Update approved references

Run this intentionally after reviewing an expected visual change:

```bash
./gradlew :screenshot-tests:updateDebugScreenshotTest --no-daemon
```

Commit the generated PNG files under `screenshot-tests/src/screenshotTestDebug/reference/` with
the source change. A renamed `@PreviewTest` function creates a different reference-image name,
so treat test-function names as stable baseline identifiers.

## Validate references

```bash
./gradlew :screenshot-tests:validateDebugScreenshotTest --no-daemon
```

On a mismatch, inspect the local HTML report at
`screenshot-tests/build/reports/screenshotTest/preview/debug/index.html`. Do not update reference
images merely to make a failing comparison pass; first review the generated diff.
