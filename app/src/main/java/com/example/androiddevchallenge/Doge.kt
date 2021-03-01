/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

internal data class Doge(
    val name: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
)

internal val dogeList = listOf(
    Doge("Chihuahua", "Smallest breeds of dog", ""),
    Doge("Dalmatian", "Dog with unique white coat marked with black spots"),
    Doge("German Shepherd", "Working dog that originated in Germany"),
    Doge("Shiba", "Hunting dog from Japan"),
    Doge("Siberian Husky", "Medium-sized working sled dog breed"),
    Doge("Golden Retriever", "Medium-large gun dog that was bred to retrieve shot waterfowl"),
    Doge("Bulldog", "Muscular, hefty dog with a wrinkled face and a distinctive pushed-in nose"),
    Doge("Kintamani", "Dog native to the Indonesian island of Bali"),
    Doge("Welsh Sheepdog", "Landrace of herding dog from Wales"),
    Doge("Pomeranian", "Toy dog breed because of its small size"),
    Doge("Papillon", "Butterfly-like look of the long and fringed hair on the ears"),
    Doge("Bloodhound", "Originally bred for hunting deer, wild boar, and tracking people"),
    Doge("Bolognese", "Small dog breed of the bichon type, originating in Italy"),
)
