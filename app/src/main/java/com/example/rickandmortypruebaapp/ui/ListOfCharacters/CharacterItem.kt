package com.example.rickandmortypruebaapp.ui.ListOfCharacters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.rickandmortypruebaapp.domain.model.CharacterModel

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    item: CharacterModel,
) {

    var detailVisible by remember { mutableStateOf(false)}
    Row(
        modifier = modifier
            .padding(start = 6.dp, top = 12.dp, bottom = 12.dp)
    ) {

        CharacterImage(item, modifier = Modifier.size(64.dp))

        Spacer(Modifier.width(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.labelLarge
            )
            OutlinedButton(
                onClick = { detailVisible = !detailVisible },
                modifier = Modifier.align(Alignment.Start).fillMaxWidth().height(30.dp).padding(end = 100.dp)
            ) {
                Text(text = if(!detailVisible)"Ver detalle" else "Ocultar detalle", style = TextStyle(fontSize = 10.sp, color = Color.LightGray))
            }
            Spacer(Modifier.height(12.dp))
            if(detailVisible){
                Text(
                    text = "Estatus: ${item.status}" ,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Especie: ${item.species}" ,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Género: ${item.gender}" ,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Tipo: ${item.type}" ,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Origen: ${item.origin.name}" ,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Ubicación: ${item.location.name}" ,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        Divider(modifier = Modifier.padding(top = 10.dp))
    }
}

// This function may be private
@Composable
fun CharacterImage(item: CharacterModel, modifier: Modifier) {
    Surface(modifier.aspectRatio(1f), RoundedCornerShape(4.dp)) {
        Box {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .size(coil.size.Size.ORIGINAL)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }

}
