import org.sopt.carrot.data.service.ProductApiService
import org.sopt.carrot.data.service.UserService
import org.sopt.carrot.domain.repository.ProductDetailRepository
import org.sopt.carrot.data.mapper.ProductDetailMapper.toModel

class ProductDetailRepositoryImpl(
    private val productService: ProductApiService,
    private val userService: UserService
) : ProductDetailRepository {
    override suspend fun getProductInfo(productId: Long) = runCatching {
        try {
            productService.getProductDetail(productId).body()?.result?.toModel()
                ?: throw IllegalStateException("Response body is null")
        } catch (e: Exception) {
            e.printStackTrace()  // 로그 추가
            throw e
        }
    }

    override suspend fun getUserInfo(userId: Long) = runCatching {
        userService.getUserInfo(userId).body()?.result?.toModel()
            ?: throw IllegalStateException("Response body is null")
    }

    override suspend fun getSellingProducts(userId: Long) = runCatching {
        productService.getSellingProducts(userId).body()?.result?.products?.map { it.toModel() }
            ?: throw IllegalStateException("Response body is null")
    }
}
