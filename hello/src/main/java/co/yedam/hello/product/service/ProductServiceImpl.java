package co.yedam.hello.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.hello.common.DataSource;
import co.yedam.hello.product.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private ProductMapper map = sqlSession.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> productSelectList() {
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductVO vo) {
		return map.productInsert(vo);
	}

	@Override
	public int productUpdate(ProductVO vo) {
		return map.productUpdate(vo);
	}

	@Override
	public int productDelete(ProductVO vo) {
		return map.productDelete(vo);
	}

}
