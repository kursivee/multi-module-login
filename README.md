# multi-module-login
Login feature for multi-modular test application using clean architecture and dagger2

### Notes
- Eventually core-* will be ripped out into its own module
- Eventually app will be ripped out into its own module
- view/data/domain are feature level
- All classes not used outside of module must be marked internal

https://proandroiddev.com/kotlin-clean-architecture-1ad42fcd97fa

### Dependency Design
![alt text](https://github.com/kursivee/multi-module-login/blob/master/images/design-architecture.png)

