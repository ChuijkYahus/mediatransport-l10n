@file:JvmName("MediaTransportAbstractionsImpl")

package penguinencounter.mediatransport.forge

import penguinencounter.mediatransport.registry.MediaTransportRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: MediaTransportRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
