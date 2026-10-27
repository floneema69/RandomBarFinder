import com.example.randombarfinder.data.remote.dto.SearchNearbyRequest
import com.example.randombarfinder.data.remote.dto.SearchNearbyResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PlacesService {
    @Headers("X-Goog-FieldMask: places.id,places.displayName,places.location")
    @POST("v1/places:searchNearby")
    suspend fun searchNearby(@Body request: SearchNearbyRequest): SearchNearbyResponse
}