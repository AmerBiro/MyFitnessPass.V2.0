package my.myfitness.myfitnesspass.data.remote.api

import my.myfitness.myfitnesspass.data.remote.requests.user.UserRequest
import my.myfitness.myfitnesspass.data.remote.responses.SimpleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/register")
    suspend fun register(
        @Body registerRequest: UserRequest
    ): Response<SimpleResponse>

    @POST("/login")
    suspend fun login(
        @Body loginRequest: UserRequest
    ): Response<SimpleResponse>

//    @POST("/addNote")
//    suspend fun addNote(
//        @Body program: Program
//    ): Response<ResponseBody>
//
//    @POST("/deleteNote")
//    suspend fun deleteNote(
//        @Body deleteNoteRequest: DeleteNoteRequest
//    ): Response<ResponseBody>
//
//    @POST("/addOwnerToNote")
//    suspend fun addOwnerToNote(
//        @Body addOwnerRequest: AddOwnerRequest
//    ): Response<SimpleResponse>
//
//    @GET("/getNotes")
//    suspend fun getNotes(): Response<List<Program>>
}
















