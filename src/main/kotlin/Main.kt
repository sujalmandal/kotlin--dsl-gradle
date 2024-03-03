fun main(args: Array<String>) {
    import{
        implementation("io", "quarkus.arc", "1.0.0")
        implementation("io", "quarkus.scheduler", "1.0.0")
    }
}

class Dependencies {

    private var depCount : Int = 0;
    private val dependencies : MutableList<String> = mutableListOf();

    fun implementation(group : String, artefact : String, version : String?){
        depCount++;
        dependencies.add("$group:$artefact:$version")
    }

    fun getDepCount(): Int{
        return depCount;
    }
    fun list(){
        dependencies.forEach {dep-> println(dep)}
    }
}

fun import(extend: Dependencies.() -> Unit) {
    val deps = Dependencies();
    deps.extend();
    val depCount = deps.getDepCount();
    println("Total dependencies imported : $depCount");
    deps.list();
}