package com.example.socialapp.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.socialapp.R
import com.example.socialapp.presentation.models.Post
import com.example.socialapp.presentation.theme.DarkPlaceholder
import com.example.socialapp.presentation.theme.ExtraLargeSpacing
import com.example.socialapp.presentation.theme.LargeSpacing
import com.example.socialapp.presentation.theme.LightPlaceholder
import com.example.socialapp.presentation.theme.MediumSpacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun PostItem(
    post: Post,
    modifier: Modifier = Modifier
) {
    val images = listOfNotNull(post.image, post.image)
    val state = rememberPagerState { images.size }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider()
        SpacerHeight(ExtraLargeSpacing)
        UserInfoRow(
            avatar = post.userAvatar,
            name = post.userName,
            lastname = post.userLastName,
            createdAt = post.createdAt
        )
        if (images.isNotEmpty()) {
            HorizontalPager(
                modifier = Modifier.padding(vertical = LargeSpacing),
                state = state
            ) { position ->
                AsyncImage(
                    model = images[position],
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = ExtraLargeSpacing)
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSystemInDarkTheme()) DarkPlaceholder else LightPlaceholder),
                    contentScale = ContentScale.Crop
                )
            }

            HorizontalPagerIndicator(
                pagerState = state,
                pageCount = images.size
            )
        }
        if (!post.message.isNullOrBlank()) {
            SpacerHeight(LargeSpacing)
            Text(
                modifier = Modifier
                    .padding(horizontal = ExtraLargeSpacing)
                    .fillMaxWidth(),
                text = post.message,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
                lineHeight = 24.sp,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
        SpacerHeight(LargeSpacing)
        BottomInfo(
            likeCount = post.likeCount,
            commentsCount = post.commentsCount
        )
    }
}

@Composable
fun UserInfoRow(
    avatar: String?,
    name: String,
    lastname: String,
    createdAt: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularImage(
            path = avatar,
            size = 32
        )
        SpacerWidth(MediumSpacing)
        Column {
            Text(
                text = "$name $lastname",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            SpacerHeight(2.dp)
            Text(
                text = createdAt,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun BottomInfo(
    likeCount: Int,
    commentsCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.like_icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )
        SpacerWidth(size = MediumSpacing)
        Text(
            text = likeCount.toString(),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        SpacerWidth(LargeSpacing)

        Icon(
            painter = painterResource(id = R.drawable.message_icom),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )
        SpacerWidth(MediumSpacing)
        Text(
            text = commentsCount.toString(),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        SpacerWidth(LargeSpacing)
        Icon(
            painter = painterResource(id = R.drawable.dowlation_icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.save_icon),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}