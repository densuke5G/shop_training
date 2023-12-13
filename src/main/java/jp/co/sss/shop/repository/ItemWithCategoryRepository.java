package jp.co.sss.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.entity.ItemWithCategory;

public interface ItemWithCategoryRepository extends JpaRepository<ItemWithCategory, Integer> {

}
