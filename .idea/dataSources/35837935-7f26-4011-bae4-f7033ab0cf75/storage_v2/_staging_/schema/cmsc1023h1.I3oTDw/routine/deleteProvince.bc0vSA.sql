create
    definer = root@localhost procedure deleteProvince(IN id int)
begin
    update customer set province_id = null where province_id = id;
    delete from Province where Province.id= Province.id;
end;

