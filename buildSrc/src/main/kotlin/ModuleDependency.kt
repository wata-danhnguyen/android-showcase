import kotlin.reflect.full.memberProperties

// "Module" means "subproject" in terminology of Gradle API.
// To be specific each "Android module" is a Gradle "subproject"
@Suppress("unused")
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"
    const val FEATURE_CLIENT = ":feature_client"
    const val FEATURE_LEAD = ":feature_lead"
    const val FEATURE_DOCUMENT = ":feature_document"
    const val FEATURE_SCHEDULING = ":feature_scheduling"
    const val FEATURE_ONBOARDING = ":feature_onboarding"
    const val FEATURE_STORAGE_ACCESS = ":feature_storage_access"
    const val FEATURE_VEHICLE = ":feature_vehicle"
    const val FEATURE_VINSCAN = ":feature_vinscan"

    const val FEATURE_HAIL = ":feature_hail"
    const val FEATURE_PART = ":feature_part"
    const val FEATURE_PDR = ":feature_pdr"
    const val FEATURE_RRRI = ":feature_rrri"

    const val LIBRARY_TEST_UTILS = ":library_test_utils"

    // False positive" function can be private"
    // See: https://youtrack.jetbrains.com/issue/KT-33610
    /*
    Return list of all modules in the project
     */
    fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    /*
     Return list of feature modules in the project
     */
    fun getFeatureModules(): Set<String> {
        val featurePrefix = ":feature_"
        val featurePrefixService = ":feature_"

        return getAllModules()
            .filter { it.startsWith(featurePrefix) || it.startsWith(featurePrefixService) }
            .toSet()
    }
}
